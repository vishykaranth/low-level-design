package DesignPatterns.Factory.DIFramework;

public interface IngestionService {

    default void ingestDataToMyDatabase(String source) {

        //SourceDataFromFile sourceDataFromFile = new SourceDataFromFile();
        IngestToDatabase sourceObject = getInstanceOfSource(source);
        sourceObject.ingestData();
    }

    IngestToDatabase getInstanceOfSource(String source);
}
