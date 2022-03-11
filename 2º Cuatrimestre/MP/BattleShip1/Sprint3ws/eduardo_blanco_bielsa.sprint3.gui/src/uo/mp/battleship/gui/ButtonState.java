package uo.mp.battleship.gui;

/**
 * Represents the state of a button on the game board view (different from the
 * state on the Game) This class is part of the Presenter
 */
/* package */ class ButtonState {

	private boolean isShot = true; // not shot
	private String text = "";

	private boolean hasOceanIcon = false; 
	private boolean hasShipIcon = false;
	private boolean isHitIcon = false;
	private boolean isMissedIcon = false;
	
	
	public ButtonState(boolean isShot, String text, boolean hasOcean, 
			boolean hasShip, boolean isHit, boolean isMissed) {
		this.isShot = isShot;
		this.text = text;
		this.hasOceanIcon = hasOcean;
		this.hasShipIcon = hasShip;	
		this.isHitIcon = isHit;
		this.isMissedIcon = isMissed;
	}

	public String getText() {
		return this.text;
	}

	public boolean isEnabled() {
		return !this.isShot;
	}

	public boolean hasOceanIcon() {
		return hasOceanIcon;
	}

	public boolean hasShipIcon() {
		return hasShipIcon;
	}

	public boolean isShot() {
		return isShot;
	}

	public boolean hasMissedIcon() {
		return isMissedIcon;
	}
	
	public boolean isHitIcon() {
		return isHitIcon;
	}
}
