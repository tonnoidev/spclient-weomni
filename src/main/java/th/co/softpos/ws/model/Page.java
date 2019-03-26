package th.co.softpos.ws.model;

public class Page {

    private String totalElements;
    private String totalPages;
    private String size;
    private String hasNext;
    private String hasPrevious;

    public String getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(String totalElements) {
        this.totalElements = totalElements;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHasNext() {
        return hasNext;
    }

    public void setHasNext(String hasNext) {
        this.hasNext = hasNext;
    }

    public String getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(String hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    @Override
    public String toString() {
        return "Page{" + "totalElements=" + totalElements + ", totalPages=" + totalPages + ", size=" + size + ", hasNext=" + hasNext + ", hasPrevious=" + hasPrevious + '}';
    }

}
