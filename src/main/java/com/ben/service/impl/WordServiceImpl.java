
package com.ben.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ben.entity.Category;
import com.ben.entity.Dict;
import com.ben.entity.Word;
import com.ben.service.ServiceSupport;
import com.ben.service.WordService;


@Service
public class WordServiceImpl  extends ServiceSupport  implements WordService {
	@Override
	public void saveWord(Word word) {
		baseHibernateDAO.save(word);
	}
	@Override
	public void saveCategory(Category category) {
		baseHibernateDAO.save(category);
	}
	
	@Override
	public Dict getDict(String xiefa) {
		String hql=" from Dict where xiefa=:xiefa";
		Map<String, Object> paramMap = new HashMap<String, Object>(1);
		paramMap.put("xiefa",xiefa);
		List<Dict> list=baseHibernateDAO.find(hql, paramMap);
		if(list!=null&&list.size()>=1){
			return list.get(0);
		}
		return null;
	} 
	
	@Override
	public List<Word> noExplainedWrod() {
		String hql=" from Word where shiyi is null";
		Map<String, Object> paramMap = new HashMap<String, Object>(1);
		return baseHibernateDAO.find(hql, paramMap);
 	} 


//	@Override
//	public Pagination<Word> page(Word conditions, Page page) {
//		StringBuilder sqlSb = new StringBuilder();
//		sqlSb.append("select ma.sec_id as secId,count(ma.sec_id) as cts,ms.reason_id as rId ")
//		.append("from monitor_article ma left join monitor_stock ms ")
//		.append("on ma.sec_id = ms.sec_id and ms.monitor_pool_id = 5 ")
//		.append("left join market_security msec on ma.sec_id = msec.id ")
//		.append("where ma.sec_id = msec.id and ma.sec_id is not null and ma.category = 1 ");
//		Security sec = conditions.getSecurity();
//		Map<String, Object> paramMap = new HashMap<String, Object>(1);
//		if (sec != null) {
//			String secCondition = sec.getSecName();
//			if (!StringUtil.isNvl(secCondition)) {
//				sqlSb.append("and (msec.sec_code like :scn or msec.sec_name like :scn) ");
//				paramMap.put("scn", "%" + secCondition + "%");
//			}
//		}
//		sqlSb.append("group by ma.sec_id,ms.reason_id ");
//		Order order = PageUtil.getOrder(page);
//		if (order != null) {
//			sqlSb.append(" order by " + order.toString());
//		} else {
//		    sqlSb.append(" order by ms.reason_id desc ");
//		}
//		Pagination<Object[]> objsPage = baseHibernateDAO.getNativeAggregateList(sqlSb.toString(), 
//				paramMap, page.getPage(), page.getRows());
//		Pagination<Word> result = new Pagination<Word>();
//		result.setPage(objsPage.getPage());
//		result.setPageSize(objsPage.getPageSize());
//		result.setRecord(objsPage.getRecord());
//		result.setResult(transformArt(objsPage.getResult()));
//		return result;
//	}
//
//	private List<Word> transformArt(List<Object[]> objsList) {
//		List<Word> result = new ArrayList<Word>(objsList.size());
//		long j = 0;
//		for (Object[] objs : objsList) {
//			Word art = new Word();
//			art.setId(j++);
//			int i = 0;
//			long secId = ((Number) objs[i++]).longValue();
//			art.setSecurity(securityService.getSecurityById(secId));
//			long counts = ((Number) objs[i++]).longValue();
//			art.setCounts(counts);
//			Number reasonId = (Number) objs[i];
//			art.setStatus(reasonId != null);
//			result.add(art);
//		}
//		return result;
//	}
//
//	@Override
//	public Pagination<Word> detailPage(Page page, Word conditions) {
//		//Date proDate = DateUtil.dateToStartTime(new Date());
//		StringBuilder hqlSb = new StringBuilder("from Word where security.id = :secId "
//				+ "and category = :category");
//		Order order = PageUtil.getOrder(page);
//		if (order != null) {
//			hqlSb.append(" order by " + order.toString());
//		}
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("secId", conditions.getSecurity().getId());
//		paramMap.put("category", ArticleCategoryEnum.N);
//		//paramMap.put("proDate", proDate);
//		return baseHibernateDAO.list(hqlSb.toString(), paramMap, page.getPage(), page.getRows());
//	}

    

}
