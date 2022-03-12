package dev.glassym.exception.exception;

// 특정 게시판의 게시글을 가져오려 하는데
// 그 게시판에 게시글이 없을 때
public class PostNotInBoardException extends BaseException{
    public PostNotInBoardException(){
        super("post not in board");
    }
}
