package kr.ymtech.ojt.board_responseentity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ymtech.ojt.board_responseentity.dto.Board;

/**
 * 게시판 목록 조회 클래스
 * 
 * @author zeonghun
 * @since 2023.04.07
 */
@RestController
@RequestMapping("/restboards")
public class BoardRestController {

    /**
     * 게시판 전체 목록을 조회하는 메소드
     * 
     * @return 게시판 전체 목록
     * 
     * @author zeonghun
     * @since 2023.04.07
     */
    @GetMapping("/list")
    public List<Board> showBoard() {
        // http://localhost:8080/restboards/list
        List<Board> boards = Arrays.asList(
                new Board(1, "test", "관리자", "test 입니다."),
                new Board(2, "스프링 설명서", "익명1", "Spring 어떻게 쓰나요?"),
                new Board(3, "annotation 사용하기", "익명2", "@Controller 사용하기"),
                new Board(4, "스프링부트란 무엇인가", "김정훈", "자바 프레임워크"),
                new Board(5, "mysql과 mariadb의 차이", "홍길동", "차이가 무엇일까"));

        return boards;
    }

    /**
     * RequestParam을 이용하여 게시판 특정 목록을 조회하는 메소드
     * 
     * @return 게시판 특정 목록, 상태 코드
     * 
     * @author zeonghun
     * @since 2023.04.07
     */
    @GetMapping
    public ResponseEntity<Board> showParamBoard(@RequestParam int bno) {
        // http://localhost:8080/restboards?bno=11
        System.out.println("bno: " + bno);
        Board board = new Board(11, "스프링부트란 무엇인가", "김정훈", "자바 프레임워크");

        if (board.getBno() < 1 || board.getBno() > 10) {
            return ResponseEntity.badRequest().build();
        }
    
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    /**
     * PathVariable을 이용하여 게시판 특정 목록을 조회하는 메소드
     * 
     * @return 게시판 특정 목록, 상태 코드
     * 
     * @author zeonghun
     * @since 2023.04.07
     */
    @GetMapping("/{bno}")
    public ResponseEntity<Board> showPathBoard(@PathVariable("bno") int bno) {
        // http://localhost:8080/restboards/11
        System.out.println("bno: " + bno);
        Board board = new Board(11, "mysql과 mariadb의 차이", "홍길동", "차이가 무엇일까");

        if (board.getBno() < 1 || board.getBno() > 10) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    /**
     * PathVariable을 이용하여 게시판 특정 목록을 조회하는 메소드
     * 
     * @return 게시판 특정 목록, 상태 코드
     * 
     * @author zeonghun
     * @since 2023.04.07
     */
    @GetMapping("/name/{writer}")
    public ResponseEntity<Board> showPathBoard(@PathVariable("writer") String writer) {
        System.out.println("writer: " + writer);
        Board board = new Board(1, "test", "관리자", "test 입니다.");

        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}