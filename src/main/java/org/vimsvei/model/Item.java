package org.vimsvei.model;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Item {
    public String type;

    public String code;

    public ParentLink parent;

    public NastedCount nasted;

    public ItemText name;

    public ItemText description;

    public Item(){

    }

    public Item(String[] array) {

        this.type = array[4];
        this.code = array[3];

        ParentLink parent = new ParentLink();
        parent.categoryCode = array[0];
        parent.segmentCode = array[1];
        parent.groupCode = array[2];
        this.parent = parent;

        NastedCount nasted = new NastedCount();
    		nasted.segments = array[5];
    		nasted.groups = array[6];
    		nasted.processes = array[7];
        this.nasted = nasted;

        ItemText text = new ItemText();
        text._ru = array[8];
        text._en = "";
        this.name = text;

        text._ru = array[8];
        text._en = "";
        this.description = text;

    }

    public Document toDocument() {
        Document document = new Document();
        document.put("type", this.type);
        document.put("code", this.code);
        document.put("parent", this.parent.toDocument());
        document.put("nasted", this.nasted.toDocument());
        document.put("name", this.name.toDocument());
        document.put("description", this.description.toDocument());
        document.put("_id", new ObjectId().toString());

        return document;
    }
}
