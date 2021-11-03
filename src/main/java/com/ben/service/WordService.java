
package com.ben.service;

import java.util.List;

import com.ben.entity.Category;
import com.ben.entity.Dict;
import com.ben.entity.Word;


 
public interface WordService {
	public void saveWord(Word word);

	void saveCategory(Category category);

	Dict getDict(String xiefa);

	List<Word> noExplainedWrod();
 
}
