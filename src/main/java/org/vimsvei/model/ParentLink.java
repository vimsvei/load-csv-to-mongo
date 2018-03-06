package org.vimsvei.model;

import org.bson.Document;

public class ParentLink {
    public String categoryCode;

    public String segmentCode;

    public String groupCode;

    public Document toDocument() {
        Document document = new Document();
        document.put("category", this.categoryCode);
        document.put("segment", this.segmentCode);
        document.put("group", this.groupCode);

        return document;
    }
}
