package net.developia.greenfood.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Recipe_likesDTO{
	private int no;
	private int recipe_no;
	private String member_id;
	private Date like_date;
}
