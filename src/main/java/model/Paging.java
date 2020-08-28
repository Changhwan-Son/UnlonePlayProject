package model;

public class Paging {

    // 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수,마지막페이지, SQL 쿼리에 쓸 start, end
    private int nowPage, startPage, endPage, total, lastPage, start, end;
    private int cntPage = 5;
    private int cntPerPage = 10;

    public Paging(int total, int nowPage) {
        setNowPage(nowPage);
        setCntPage(cntPerPage);
        setTotal(total);
        calcLastPage(getTotal());
        calcStartEndPage(getNowPage(), cntPage);
        calcStartEnd(getNowPage());
    }

    // 제일 마지막 페이지 계산
    public void calcLastPage(int total){
        setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
    }

    // 시작, 끝 페이지 계산
    public void calcStartEndPage(int nowPage, int cntPage){
        setEndPage(((int) Math.ceil((double)nowPage / (double)cntPage)) * cntPage);

        if(getLastPage() < getEndPage()){
            setEndPage(getLastPage());
        }
        setStartPage(getEndPage() - cntPage + 1);
        if(getStartPage() < 1){
            setStartPage(1);
        }
    }

    // DB 쿼리에서 사용할 start, end 값 계산
    public void calcStartEnd(int nowPage){
        setEnd(nowPage * cntPerPage);
        setStart(getEnd() - cntPerPage + 1);
    }

    public int getCntPage() {
        return cntPage;
    }

    public int getCntPerPage() {
        return cntPerPage;
    }

    public int getEnd() {
        return end;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public int getStart() {
        return start;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getTotal() {
        return total;
    }

    public void setCntPage(int cntPage) {
        this.cntPage = cntPage;
    }

    public void setCntPerPage(int cntPerPage) {
        this.cntPerPage = cntPerPage;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
