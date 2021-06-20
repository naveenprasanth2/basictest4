package practise;

public enum DropDown {
	INDEX {
		@Override
		public String toString() {
			return "index";
		}
	},
	VALUE {
		@Override
		public String toString() {
			return "value";
		}
	},
	VISIBLETEXT {
		public String toString() {
			return "visibleText";
		}
	}

}
