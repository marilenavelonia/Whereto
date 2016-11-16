  import java.util.regex.Pattern;
  import java.util.regex.Matcher;


  public class LinkExtracting {
  	//...
      while ((line = rd.readLine()) != null) {
         //object result contains src of the page being crawled
      	result.append(line);

      	//<a tag pattern that indicates a link in html code
      	public final String ATagPattern = "(?i)<a([^>]+)>(.*?)</a>";
      	//<a href pattern that is a URL
      	public final String AHrefTagPattern = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

      	tagPattern = Pattern.compile(ATagPattern);
      	linkPattern = Pattern.compile(AHrefTagPattern);

      	tagMatcher = tagPattern.matcher(line);

      	//while the <a pattern exists in line, extract the href and the link text from the html link line
      	while (tagMatcher.find()) {
      		String href = tagMatcher.group(1);
      		String linkText = tagMacher.group(2);

      		linkMatcher = linkPattern.matcher(href);

      			//while the href pattern matches the href String, extract the URL
      			while (linkMatcher.find()) {
      				String link = linkMatcher.group(1);

					//if line does not represent an internal link, an email link or a document-download link then save link and text link in database
					if ((line.contains("<\P>") == false) && (line.contains("@") == false) && (line.contains("zip") == false)) {
      				//save sti vasi dedomenwn tou link kai tou linktext
      				}
      			}
      	}
      }
}


