package org.vimsvei.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.vimsvei.model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    private final static String MONGO_HOST = "192.168.99.100";
    private final static int MONGO_PORT = 32768;
    private final static String FILE_CSV = "/Users/vimsvei/workspace/loadtomongo/src/main/resources/processes.csv";
    private final static String SIGN_CSV = ";";

    public static void main( String[] args )
    {
        String line = "";

        try {

            MongoClient mongoClient = new MongoClient( MONGO_HOST , MONGO_PORT );
            MongoDatabase database = mongoClient.getDatabase("processes-of-bank");
            MongoCollection<Document> collection = database.getCollection("processes");

            if (collection.count() > 0) {
                collection.drop();
                database.createCollection("processes");
                collection = database.getCollection("processes");
            }

//            List<Item> items = new ArrayList<Item>();

            BufferedReader reader = new BufferedReader(new FileReader(FILE_CSV));
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(SIGN_CSV);
                Item item = new Item(array);
//                items.add(item);
                collection.insertOne(item.toDocument());
            }

//            collection.insertMany(items);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
