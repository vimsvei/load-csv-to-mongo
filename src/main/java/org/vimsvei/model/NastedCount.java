package org.vimsvei.model;

import org.bson.Document;

public class NastedCount {
    public String segments;

    public String groups;

    public String processes;

    public Document toDocument() {
        Document document = new Document();
        document.put("segments", this.segments);
        document.put("groups", this.groups);
        document.put("processes", this.processes);

        return document;
    }
}
