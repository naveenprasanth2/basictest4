package practise2;

public enum DropValues {
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
