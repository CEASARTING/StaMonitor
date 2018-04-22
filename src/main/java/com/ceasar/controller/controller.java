package com.ceasar.controller;

import com.ceasar.domian.User;
import org.jcouchdb.db.Database;
import org.jcouchdb.db.Response;
import org.jcouchdb.db.Server;
import org.jcouchdb.db.ServerImpl;
import org.jcouchdb.document.BaseDocument;
import org.jcouchdb.document.ValueRow;
import org.jcouchdb.document.ViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.svenson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dp on 2018/4/16.
 */
@Controller
@RequestMapping("/test")
public class controller {
    @Autowired
    private BaseDocument baseDocument;
    @Autowired
    private Database database;



    @ResponseBody
    @RequestMapping("/resiver")
    public String resiver(){


        Map<String,String> doc = new HashMap<String, String>();
        doc.put("foo", "value for the foo attribute");
        doc.put("bar", "value for the bar attribute");

        // create the document in couchdb
        database.createDocument(doc);


        /*BaseDocument document = new BaseDocument();
        document.setId("test");
        document.setProperty("privilege", "111 010");
        database.createDocument(document);*/

        /*System.out.println("+++++++++++");
        JSON json = new JSON();

        String temp = json.forValue(baseDocument);
        System.out.println(temp);

        Response resp = database.getServer().post("/" + "dp" + "/", temp);

        //BaseDocument baseDocument = database.getDocument(BaseDocument.class,"4667488c25f99c2a2fadd900b60003f9");
        System.out.println(baseDocument.getId());*/
        baseDocument.setProperty("one", "111 010");
        database.createOrUpdateDocument(baseDocument);
        //database.

        return "success";


    }

    @ResponseBody
    @RequestMapping("/give")
    public BaseDocument give(){


        //BaseDocument baseDocument = database.getDocument(BaseDocument.class,"4667488c25f99c2a2fadd900b60003f9");
        //System.out.println(baseDocument.getId());

        //System.out.println(baseDocument.getProperty("one"));

        /*ViewResult<Map> results = database.listDocuments(null, null);
        System.out.println(results);
        List<ValueRow<Map>> datalist = results.getRows();
        for (ValueRow<Map> valueRow : datalist) {
            String docId = valueRow.getId();
            Map<String, String> map = database.getDocument(Map.class, docId);
            System.out.println(map.get("name"));
            System.out.println(map.get("_id"));
        }*/

        return baseDocument;

    }








}
