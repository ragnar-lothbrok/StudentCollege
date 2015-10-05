package sample.spring.ibatis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageSupporter<T> {

    public PageSupporter() {
        metaData = new HashMap<String, Object>();
    }

    private Map<String, Object> metaData;
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Map<String, Object> getMetaData() {
        if(metaData == null)
            metaData = new HashMap<String, Object>();
        return metaData;
    }

    public void setMetaData(Map<String, Object> metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "PageSupporter [metaData=" + metaData + ", items=" + items + "]";
    }

}
