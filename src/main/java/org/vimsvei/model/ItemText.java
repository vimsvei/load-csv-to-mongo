package org.vimsvei.model;

import org.bson.Document;

public class ItemText {
    public String _ru;

    public String _en;

    public Document toDocument() {
        Document document = new Document();
        document.put("ru", this._ru);
        document.put("en", this._en);

        return document;
    }
}
