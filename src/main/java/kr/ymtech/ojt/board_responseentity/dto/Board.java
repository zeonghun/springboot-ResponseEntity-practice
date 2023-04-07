package kr.ymtech.ojt.board_responseentity.dto;

/**
 * 게시판 항목 저장 클래스
 * 
 * @author zeonghun
 * @since 2023.04.07
 */
public class Board {
    private int bno;
    private String title;
    private String writer;
    private String content;

    public Board(int bno, String title, String writer, String content) {
        this.bno = bno;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public int getBno() {
        return this.bno;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getContent() {
        return this.content;
    }
}