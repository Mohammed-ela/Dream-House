package engine.mobile;

import engine.map.Case;

public abstract class MobileElement {
	

		private Case position ;
		
		public MobileElement() {
			this.position = new Case(0,0);
		}
		

		public MobileElement(Case position) {
			this.position = position;
		}

		public Case getPosition() {
			return position;
		}

		public void setPosition(Case position) {
			this.position = position;
		}

	

}
