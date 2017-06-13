//Sms Permiison
/*
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.RECEIVE_SMS" />

*/
//access to permsions
 void CheckUserPermsions()

    {
        if (Build.VERSION.SDK_INT >= 23)
        {
            if ((ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)

                    != PackageManager.PERMISSION_GRANTED)

                        &&

                    (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED))
            {
                if ((!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
                        &&
                   (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)))
                {


                    requestPermissions(new String[]
                     {
                      android.Manifest.permission.ACCESS_FINE_LOCATION,
                      android.Manifest.permission.READ_CONTACTS
                     }, REQUEST_CODE_ASK_PERMISSIONS);
                    return;
                }
            }
        }

        GetLocation();// init the contact list

    }

    //get acces to location permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        switch (requestCode)
        {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    GetLocation();// init the contact list
                }

                else if (grantResults[1] == PackageManager.PERMISSION_GRANTED)
                {



                }

                else

                    {
                    // Permission Denied
                    Toast.makeText(this, "you Denied the Permission", Toast.LENGTH_SHORT).show();
                    }

                break;

                default:

                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


//Get last location
  public  void getLastLocation(){
  	    LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
  	        Location myLocation=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (myLocation == null) 
                {
                    myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

                }
    }


//read contact list
      public  void getContactList(){
 ArrayList<ListItem> list_contact=new ArrayList<ListItem>() ;
            Cursor cursor = getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null, null);
            while (cursor.moveToNext()) {
                String name =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                list_contact.add(new ListItem(name, phoneNumber));


            }

      }



public class ListItem {
    public String Title;
    public String phoneNumber;
    public ListItem(String Title, String phoneNumber)
    { this. Title=Title;
        this. phoneNumber=phoneNumber;
    }
}



//ratinal permmison
    if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
             android.Manifest.permission.READ_CONTACTS)) {
    }

