package org.zerock.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude="files") //양방향에서 주의하기
@EqualsAndHashCode(of="pno") //피케이 값으로만 설정 가능
//@Data 양방향 참조에서는 이것 절대 금지. 스택오버플로우 
public class PDS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	private String title;
	private String writer;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //테이블이 하나 더 생김
	@JoinColumn(name="pdsno") //onetomany를 막고 컬럼을 만듬
	private List<PDSFile> files;
	

}
