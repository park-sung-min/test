package ch10.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ch07.xml.search.SearchClientFactory;
import ch07.xml.search.SearchDocument;

/*
 * 다같이 연결!
 * @Autowired  :  spring  : type 확인
 * @Resourse   :  java    : id, name 확인
 * @Inject     :  java    : type 확인
 */
//컨테이너 빈을 포함한 객체

@Component // 컨테이너!
public class ProductService {
	private SearchClientFactory searchClientFactory;
	
	
	//참조 하고 싶을때 : Resource
	@Resource(name = "productSearchClientFactory")
	public void setSearchClientFactory(SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}
	
	public void createProduct(ProductInfo pi) {
		searchClientFactory.create().addDocument(toSearchDocument(pi));
	}
	
	private SearchDocument toSearchDocument(ProductInfo pi){
		return new SearchDocument();
	}
}
