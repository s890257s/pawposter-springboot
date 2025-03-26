package tw.per.allen.model.enums;

public enum VoteState {
	LIKE(1), UNLIKE(0), NOT_VOTE(-1);

	public Integer typeNumber;

	VoteState(Integer i) {
		typeNumber = i;
	}

	public static VoteState valueOf(Integer i) {
		return switch (i) {
		case 1 -> VoteState.LIKE;
		case 0 -> VoteState.UNLIKE;
		default -> VoteState.NOT_VOTE;
		};
	}

}
