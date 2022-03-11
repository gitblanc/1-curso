package dome.entities;

public class Item {

	private String title;
	private int playingTime;
	private boolean gotIt;
	private String comment;

	public Item() {
		super();
	}

	protected void setTitle(String title) {
		if (title != null) {
			this.title = title;
		}
	}

	protected void setPlayingTime(int playingTime) {
		if (playingTime > 0) {
			this.playingTime = playingTime;
		}
	}

	protected void setOwn(boolean ownIt) {
		gotIt = ownIt;
	}

	protected void setComment(String comment) {
		if (comment != null) {
			this.comment = comment;
		}
	}

	protected String getComment() {
		return comment;
	}

	protected boolean getOwn() {
		return gotIt;
	}

	protected String getTitle() {
		return this.title;
	}

	protected int getPlayingTime() {
		return this.playingTime;
	}

}