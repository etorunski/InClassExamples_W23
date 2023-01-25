package algonquin.cst2335.torunse.data;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    //Holds a string , but notifies observers when changed
    public MutableLiveData<String> editTextContents = new MutableLiveData<>();
    public MutableLiveData<Boolean> isSelected  = new MutableLiveData<>(false);

}
