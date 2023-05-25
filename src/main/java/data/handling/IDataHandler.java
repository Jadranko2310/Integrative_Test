package data.handling;

/**
 * Data handler interface. Will have implementations based on testing entity and
 * DB with different test data in different env.
 */
public interface IDataHandler {

  void prepareData() throws Exception;

  void cleanData();
}
