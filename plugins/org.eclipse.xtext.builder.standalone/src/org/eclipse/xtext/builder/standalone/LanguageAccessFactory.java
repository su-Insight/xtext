/**
 * 
 */
package org.eclipse.xtext.builder.standalone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Injector;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class LanguageAccessFactory {

	public Map<String,LanguageAccess> createLanguageAccess(List<? extends ILanguageConfiguration> languageConfigs, ClassLoader compilerClassLoder) {
		Map<String,LanguageAccess> result = new HashMap<String, LanguageAccess>();
		for (ILanguageConfiguration languageGenConf : languageConfigs) {
			ISetup setup;
			try {
				Class<?> loadClass = compilerClassLoder.loadClass(languageGenConf.getSetup());
				if (!ISetup.class.isAssignableFrom(loadClass)) {
					throw new IllegalArgumentException("Language setup class " + languageGenConf.getSetup()
							+ " must implement " + ISetup.class.getName());
				}
				setup = (ISetup) loadClass.newInstance();
			} catch (Exception e) {
				throw new IllegalStateException("Failed to load language setup for class '"+languageGenConf.getSetup()+"'.", e);
			}

			Injector injector = setup.createInjectorAndDoEMFRegistration();
			IResourceServiceProvider serviceProvider = injector.getInstance(IResourceServiceProvider.class);
			FileExtensionProvider fileExtensionProvider = injector.getInstance(FileExtensionProvider.class);
			LanguageAccess languageAccess = new LanguageAccess(languageGenConf.getOutputConfigurations(), serviceProvider, languageGenConf.isJavaSupport());
			for (String extension : fileExtensionProvider.getFileExtensions()) {
				result.put(extension, languageAccess);
			}
		}
		return result;
	}
	
}
