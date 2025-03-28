package tw.per.allen.config;

import tw.per.allen.model.dto.MemberDto;

public class MemberHolder {
	private static final ThreadLocal<MemberDto> threadLocal = new ThreadLocal<>();

	public static void setMember(MemberDto member) {
		threadLocal.set(member);
	}

	public static MemberDto getMember() {
		return threadLocal.get();
	}

	public static void clear() {
		threadLocal.remove();
	}
}
