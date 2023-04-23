package spring.core.session03.mvc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component(value = "student")
@Component // 相當於 @Component(value = "user")
public class User {
	
	@Value(value = "John")
	private String username; // 姓名
	
	@Value(value = "22")
	private Integer age; // 年齡
	
	// #{..} 這是一個 SpringEL 表達式
	// ${..} 表示取得屬性值
	// 「:」 後面代表預設值
	// ${nickname: {'Baby', 'Lucky'}} 表示若找不到 nickname 的屬性值就使用 {'Baby', 'Lucky'}
	@Value(value = "#{${nickname: {'Baby', 'Lucky'}}}")
	private String[] nickname; // 暱稱
	
	@Value(value = "#{${subjects: {'Java', 'Python'}}}")
	private Set<String> subjects; // 科目
	
	@Value(value = "#{${scores: {100, 90}}}")
	private List<Integer> scores; // 成績
	
	@Value(value = "#{${hobbies: {'1':'Program', '2':'BaseBall'}}}")
	private Map<String, String> hobbies; // 興趣

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<String, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", nickname=" + Arrays.toString(nickname) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
	
	
	
}
