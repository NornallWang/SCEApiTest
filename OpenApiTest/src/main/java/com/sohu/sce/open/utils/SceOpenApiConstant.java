package com.sohu.sce.open.utils;

public interface SceOpenApiConstant {

	public static final String SIGNATURE = "signature";
	public static final String SIGNATURE_METHOD = "signature_method";
	public static final String SIGNATURE_VERSION = "signature_version";
	
	public static final String TIMESTAMP = "timestamp";
	public static final String ACCESS_KEY = "access_key";
	public static final String VERSION = "api_version";
	
	public static final String SIGNATURE_VERSION_DEFAULT = "1.0";
	
	interface Limit{
		public static final String PROJECT="sceopenapi";
		
		interface Type {
			public static final String USER="user";
			public static final String IP="ip";
			public static final String ALL="all";
		}
	}
}
