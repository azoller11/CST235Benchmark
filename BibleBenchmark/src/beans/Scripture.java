package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Scripture {

	String scripture;

	public Scripture() {
		this.scripture = this.getScripture();
	}

	public Scripture(String scripture) {
		this.scripture = scripture;
	}

	public String getScripture() {
		return scripture;
	}

	public void setScripture(String scripture) {
		this.scripture = scripture;
	}

	public String formattedScripture() {
		String uf = getScripture();
		String f = "";
		String uc = "";
		// Find where the text starts
		boolean found = false;
		int index = 0;
		if (getScripture() != null && getScripture() != " " && getScripture() != "") {
			if (!uf.contains("preview")) {
				f = uf;
			}  else {
				while (!found) {
					if (!uc.contains("preview")) {
						uc += uf.charAt(index);
						index++;
					} else {
						if (!f.contains(".â")) {
							f += uf.charAt((index) + 2);
							index++;
							System.out.println(f);
						} else {
							System.out.println(f);
							f = f.substring(0, (f.length() - 2));
							found = true;

						}
					}
				}
			}
			
		}

		return f;
	}
}

/*
 * func({"reference":"Matthew 1:1","verses":[{"book_id":"MAT","book_name":
 * "Matthew","chapter":1,"verse":1,
 * "text":"The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.\n"
 * }],
 * "text":"The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.\n"
 * ,"translation_id":"web","translation_name":"World English Bible"
 * ,"translation_note":"Public Domain"})
 * 
 */