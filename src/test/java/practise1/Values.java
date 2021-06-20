package practise1;

public enum Values {
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
		@Override
		public String toString() {
			return "visibeltext";
		}
	}
}
