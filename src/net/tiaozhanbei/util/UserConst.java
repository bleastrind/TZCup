package net.tiaozhanbei.util;

public final class UserConst {
	public static class Type{
		public static int MANAGER=1;
		public static int NEWSUSER=2;
		public static int AUTHOR=3;
		public static int JUDGER=4;
		public static int COMPANY=5;
		public static int COMMONUSER=6;
	}
	
	public static class Sex{
		public static int UNKNOWN=0;
		public static int MALE=1;
		public static int FEMALE=2;
	}
	public static class SubScores{
		
		public static int SubScore=10;
		public static int AddScore=10;
	}
	
	public static class Authority{
		public static String ADMIN = "ROLE_ADMIN";
		public static String USER = "ROLE_USER";
		public static String NEWS = "ROLE_NEWS";
		public static String AUTHOR = "ROLE_AUTHOR";
		public static String COMPANY = "ROLE_COMPANY";
		public static String JUDGER = "ROLE_JUDGER";
	}
}
