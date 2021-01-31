package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.view.BrandViewModel;
import java.util.List;
import org.springframework.stereotype.Service;

public interface BrandService {
  List<BrandViewModel> getAllBrands();
}
