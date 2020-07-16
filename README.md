
#  بِسْمِ اللَّـهِ الرَّحْمَـٰنِ الرَّحِيمِ


# CheckInternet


# Arabic 
	مكتبة بسيطة لنظام الاندرويد
	لفحص الأنواع المختلفة من اتصالات الشبكة،
	للسماح لتطبيق بالتحقق من حالة اتصال الإنترنت
	قبل إجراء طلبات
	HTTP.
# Endlish
	A Simple Android library to check  network connection,
	to allow an app check internet connectivity status before making HTTP Requests.



# Installing
```ruby
	repositories {
			
			maven { url 'https://jitpack.io' }
		}
	
  
  

	dependencies {
	implementation 'com.github.3shy:CheckInternet:2.0.0'
	}
```
	
# Permissions	
```ruby
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	<uses-permission android:name="android.permission.INTERNET"/>
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```
	

# Quick Example


```ruby




	import com.nocv.newapp.checker.Checker;
	import com.nocv.newapp.checker.interfaced.Monitor;


	public class Mohamed_Ashry extends AppCompatActivity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Checker.from(this).monitor(new Monitor.ConnectivityListener() {
		    @Override
		    public void onConnectivityChanged(int connectionType, boolean isConnected, boolean isFast) {
			if (isConnected){
			    // have Internet Connection
			    Toast.makeText(Mohamed_Ashry.this, "have Internet Connection", Toast.LENGTH_SHORT).show();
			}else {
			    // don't have Internet Connection
			    Toast.makeText(Mohamed_Ashry.this, "don't have Internet Connection", Toast.LENGTH_SHORT).show();

			}


		    }
		});


	    }

		    @Override
		    protected void onStop() {
			Checker.from(this).stop();
			super.onStop();
		 }
	}
```

  

# Author

Mohamed Ashry [GitHub 3shry](https://github.com/3shy).

Mohamed Ashry [FaceBook 3shry](facebook.com/mohmed.ashry.716/).

Mohamed Ashry [Linkedin](https://www.linkedin.com/in/mohamed-ashry-b8758813a/).



