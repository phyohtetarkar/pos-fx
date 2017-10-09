package com.jsoft.pos.util;

public class RepositoryFactory {

	public enum Provider {
		RETROFIT
	}

	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> repo, Provider provider) {
		try {
			String pkg = String.format("%s.%s.", repo.getPackage().getName(), provider.name().toLowerCase());
			
			return (T) Class.forName(pkg.concat(repo.getSimpleName()).concat("Impl")).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage());
		}
		
	}
	
}
