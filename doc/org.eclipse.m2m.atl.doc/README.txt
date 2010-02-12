			==============================================================================
			Notes for ATL auto generating Eclipse help content Ant script build-helper.xml
			==============================================================================

This script generates Eclipse help content from ATL wiki splitted into several wiki pages. However, it requires a few checkouts:


 1. Requirements
-----------------

This project cannot be built without:
	- Mylyn/WikiText installed. Update site:
		download.eclipse.org/tools/mylyn/update/incubator
	- the following projects in the same workspace:
			org.eclipse.mylyn.help.ui
			org.eclipse.mylyn.wikitext.core
			org.eclipse.mylyn.wikitext.mediawiki.core
		These projects are available here: /cvsroot/tools/org.eclipse.mylyn/
	REASON: special characters + images

You will also need to add two files in the org.eclipse.mylyn.help.ui Mylyn project:
	- org.eclipse.mylyn.internal.help.ui.anttask.MediaWikiImageFetcher.java
	- org.eclipse.mylyn.internal.help.ui.anttask.tasks.properties


 2. Code correction
--------------------

Furthermore, it needs a few correction into the Mylyn java code. Please take a look at the org.eclipse.mylyn.wikitext.mediawiki.core Mylyn project:

+ org.eclipse.mylyn.internal.wikitext.mediawiki.core.AbstractMediaWikiLanguage.java, l.52:

		if (QUALIFIED_INTERNAL_LINK.matcher(pageId).matches()) {
			Matcher matcher = STANDARD_EXTERNAL_LINK_FORMAT.matcher(internalLinkPattern);
			if (matcher.matches()) {
				String prefix = matcher.group(1);
				System.out.println(pageName);
				if (pageId.startsWith(prefix + "/User")) { //$NON-NLS-1$
					System.out.println("1"); //$NON-NLS-1$
					return pageId;
				} else if (pageId.startsWith(prefix + '/')) {
					System.out.println("2"); //$NON-NLS-1$
					return internalLinkPattern.substring(0, matcher.start(1)) + pageId;
				} else {
					System.out.println("3"); //$NON-NLS-1$
					System.out.println(internalLinkPattern.substring(0, matcher.start(1)) + pageId);
					return internalLinkPattern.substring(0, matcher.start(1)) + pageId;
				}
			}
		}
		String link = MessageFormat.format(super.internalLinkPattern, pageId);
		link = link.replaceAll("/ATL/", "/"); //$NON-NLS-1$//$NON-NLS-2$
		System.out.println(link);
		return link;

+ org.eclipse.mylyn.internal.wikitext.mediawiki.core.token.HyperlinkInternalReplace.java, l.61:

				if (!href.contains(":") && !href.contains("#")) { //$NON-NLS-1$ //$NON-NLS-2$ 
					try {
						href = "#" + href.split("\\.")[1].substring(1); //$NON-NLS-1$ //$NON-NLS-2$
					} catch (Exception e) {
					}
				} else if (!href.contains(":")) { //$NON-NLS-1$ 
					try {
						href = "#" + href.split("\\#")[1]; //$NON-NLS-1$ //$NON-NLS-2$
					} catch (Exception e) {
					}
				}

+ org.ecipse.mylyn.wikitext.core.util.anttask.MarkupToHtmlTask.java, l.196:

			markupContent = treatContent(markupContent);

+ org.ecipse.mylyn.wikitext.core.util.anttask.MarkupToHtmlTask.java, l.271:

	/**
	 * Treats the content for multi-page ATL splitting.<br/>
	 * <br/>
	 * <b>Note:</b> There is no modification on other pages, unless they contain the string "___ATLSPLIT___" (or
	 * "__FORCETOC__", "__TOC__" or "__NOTOC__" because these three tokens have to be removed from the eclipse help
	 * content. Actually there are more than three tokens, see the part to be fixed below)
	 * 
	 * @param content
	 *            the markup content
	 * @return the new well-formed content
	 */
	private String treatContent(String content) {
		content = content.replaceAll("__FORCETOC__", ""); //$NON-NLS-1$ //$NON-NLS-2$
		content = content.replaceAll("__TOC__", ""); //$NON-NLS-1$ //$NON-NLS-2$
		content = content.replaceAll("__NOTOC__", ""); //$NON-NLS-1$ //$NON-NLS-2$
		//FIXME: There are more than those three tokens to be removed from eclipse help content
		if (!content.contains("___ATLSPLIT___")) { //$NON-NLS-1$
			return content;
		}
		content = content.replaceAll("___ATLSPLIT___", ""); //$NON-NLS-1$ //$NON-NLS-2$
		content = content.replaceAll("<div style=\\\"\\\">[\\s]*", "<div style=\"display:none\">"); //$NON-NLS-1$//$NON-NLS-2$
		content = content.replaceAll(
				"[\\n\\r][\\s&&[^\\n\\r]]*([=]+)[ ]*([^\\n=]+)[ ]*([=]+)[\\s&&[^\\n\\r]]*[\\n\\r]", "\n$1= $2 $3=\n"); //$NON-NLS-1$//$NON-NLS-2$
		content = content.replaceAll("<div name=\\\"([^\\n]+)\\\"></div>", "= $1 ="); //$NON-NLS-1$//$NON-NLS-2$
		content = content.replaceAll("==[ ]*Updating[ ]*This[ ]*Document[ ]*==", "= Updating This Document ="); //$NON-NLS-1$//$NON-NLS-2$
		content = content.replaceFirst("\\[\\[Category:ATL\\]\\]", "[[Category_ATL]]"); //$NON-NLS-1$ //$NON-NLS-2$
		content = content.replaceAll("\\[\\[Category:ATL\\]\\]", ""); //$NON-NLS-1$ //$NON-NLS-2$
		content = content.replaceFirst("\\[\\[Category_ATL\\]\\]", "[[Category:ATL]]"); //$NON-NLS-1$ //$NON-NLS-2$
		return content;
	}


This code modifies internal links that lead to a different wiki page so that they can be correct in the eclipse help content.
