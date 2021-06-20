package practise3;

public enum Drop {

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
			return "visibletext";
		}
	}
}
