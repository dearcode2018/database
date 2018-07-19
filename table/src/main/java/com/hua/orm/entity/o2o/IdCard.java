/**
 * 描述: 
 * IdCard.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.orm.entity.o2o;

import java.util.Date;

import com.hua.entity.BaseEntity;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * IdCard
 */
public final class IdCard extends BaseEntity
{
	 /* long */
	private static final long serialVersionUID = 1L;

	/**
	 * 一个人只有一个身份证，一个身份证只属于一个人
	 */
	
	/* 身份证标题, 例如 : 中华人民共和国 - 居民身份证 */
	private String title;
	
	/* 卡id号 */
	private String cardId;
	
	/* 签发机关 (Xx市公安局) */
	private String issuingAuthority;
	
	/* 生效日期 yyyy-MM-dd */
	private Date effectiveDate;
	
	/* 失效日期 yyyy-MM-dd */
	private Date expiryDate;

	// one to one
	/* 身份证持有者 */
	private Person person;
	
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the cardId
	 */
	public String getCardId()
	{
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}

	/**
	 * @return the issuingAuthority
	 */
	public String getIssuingAuthority()
	{
		return issuingAuthority;
	}

	/**
	 * @param issuingAuthority the issuingAuthority to set
	 */
	public void setIssuingAuthority(String issuingAuthority)
	{
		this.issuingAuthority = issuingAuthority;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate()
	{
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate()
	{
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the person
	 */
	public Person getPerson()
	{
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person)
	{
		this.person = person;
	}
	
}
