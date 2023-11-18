package FileAndDirectorySystem.search;

import FileAndDirectorySystem.Entry;

import java.util.List;

public interface SearchCriteria {
    public SearchResponse search(SearchRequest searchRequest, List<Entry> directory);
}
