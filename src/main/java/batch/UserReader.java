package main.java.batch;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by Kevin
 */
@Dependent
@Named("UserReader")
public class UserReader implements ItemReader {

    @Inject
    private JobContext jobContext;

    private String fileName;

    private JsonParser parser;

    private Checkpoint checkpoint;

    private boolean start;

    @Override
    public void open(Serializable serializable) throws Exception {
        if (checkpoint == null) {
            this.checkpoint = new Checkpoint();
        }

        fileName = jobContext.getProperties().getProperty("input_file");
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("../../WEB-INF/batch-jobs/"+ fileName);
        parser = Json.createParser(inputStream);

        start = false;
        for (long i = 0; i < this.checkpoint.getCount(); ++i) {
            JsonParser.Event event = parser.next();
            if (event == JsonParser.Event.START_ARRAY) {
                start = true;
            }
        }
    }

    @Override
    public void close() throws Exception {
        parser.close();
    }

    @Override
    public Object readItem() throws Exception {
        boolean itemFound = false;
        InputUser item = new InputUser();

        System.out.println("Reading JSON-item");

        while (itemFound == false
                && parser.hasNext()) {
            JsonParser.Event event = parser.next();
            checkpoint.eventHappened();

            switch (event) {
                case START_ARRAY:
                    start = true;
                    break;
                case VALUE_STRING:
                    if (start == true) {
                        if (item.username == null) {
                            item.username = parser.getString();

                        } else if (item.bio == null) {
                            item.bio = parser.getString();

                        } else if (item.locations == null) {
                            item.locations = parser.getString();

                        } else if (item.website == null) {
                            item.website = parser.getString();
                            itemFound = true;
                        }
                    }
                    break;
                case END_ARRAY:
                    item = null;
                    break;
            }
        }
        return item;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return new Checkpoint();
    }
}
