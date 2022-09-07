package woo.edu.c.vo;

public class boardVo {
	private int boardNo;
	private String boardTitle;
	private String boardName;
	private String boardContents;
	private String regdate;
		
	
	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public String getBoardTitle() {
		return boardTitle;
	}



	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}



	public String getBoardName() {
		return boardName;
	}



	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}



	public String getBoardContents() {
		return boardContents;
	}



	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardName=" + boardName + ", boardContents=" + boardContents + ", regdate=" + regdate +"]";
	}


}
