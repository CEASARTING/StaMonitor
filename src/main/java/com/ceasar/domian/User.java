package com.ceasar.domian;

import org.jcouchdb.document.Attachment;
import org.jcouchdb.document.Document;

import java.util.Map;

/**
 * Created by dp on 2018/4/16.
 */
public class User implements Document{



    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String s) {

    }

    @Override
    public String getRevision() {
        return null;
    }

    @Override
    public void setRevision(String s) {

    }

    @Override
    public Map<String, Attachment> getAttachments() {
        return null;
    }

    @Override
    public void setAttachments(Map<String, Attachment> map) {

    }
}
