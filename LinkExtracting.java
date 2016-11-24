import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LinkExtracting {

	private String link, linkText;
	
	//method description
	public boolean extractLinks (String line, String baseURL) {
    	//i tests if the method returns true or false
      	int i = 0;

      	Pattern tagPattern, linkPattern;
      	Matcher tagMatcher, linkMatcher; 

      	//<a tag pattern that indicates a link in html code
      	final String ATagPattern = "(?i)<a([^>]+)>(.*?)</a>";
      	//<a href pattern that is a URL
      	final String AHrefTagPattern = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
		

      	tagPattern = Pattern.compile(ATagPattern);
      	linkPattern = Pattern.compile(AHrefTagPattern);
      	

      	tagMatcher = tagPattern.matcher(line);

      	//while the <a pattern exists in line, extract the href and the link text from the html link line
      	while (tagMatcher.find()) {
      		String href = tagMatcher.group(1);
      		linkText = tagMatcher.group(2);

      		linkMatcher = linkPattern.matcher(href);

      		//while the href pattern matches the href String, extract the URL
      		while (linkMatcher.find()) {
      			link = linkMatcher.group(1);

      			

      			//if the link is external or local, return true
      			if ((link.contains("www") || link.contains("http") || link.startsWith("//")) || link.startsWith("/")) {
				    i = 1;
				    if (link.startsWith("/") == true && link.startsWith("//") == false) {
						link = baseURL + link;}
				}
			}
		}

		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String getLink() {
		return link;
	}
	
	public String getLinkText(){
		return linkText;
	}
}

