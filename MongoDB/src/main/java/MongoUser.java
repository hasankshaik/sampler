import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MongoUser {

    public static void main(String args[]) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("test");
            System.out.println("Connect to database successfully")  ;

            List<String> dbs = mongoClient.getDatabaseNames();
            for(String dbx : dbs){
                System.out.println(dbx);
            }
            System.out.println("--------------------------");

            DBCollection table = db.getCollection("user");
            BasicDBObject document = new BasicDBObject();
            document.put("name", "hasan");
            document.put("age", 30);
            document.put("createdDate", new Date());
            table.insert(document);

            Set<String> tables = db.getCollectionNames();

            for(String coll : tables){
                System.out.println(coll);
            }

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", "hasan");

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
            System.out.println(db.collectionExists("user"));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
