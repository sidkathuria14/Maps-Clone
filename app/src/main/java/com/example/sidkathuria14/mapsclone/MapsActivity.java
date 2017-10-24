package com.example.sidkathuria14.mapsclone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.util.adapter.TextWatcherAdapter;
import com.example.sidkathuria14.mapsclone.api.PlacesApi;
import com.example.sidkathuria14.mapsclone.models.models_places.main_places;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

;import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.input;

public class MapsActivity extends AppCompatActivity implements LocationListener,OnMapReadyCallback,GoogleMap.OnMapClickListener,GoogleMap.OnMarkerClickListener {
//PermissionResultCallback,
    private GoogleMap mMap;
    LocationManager locMan;
    public static final String TAG = "Locations";
//    SearchView mSearchView;
FloatingSearchView mSearchView;
LocationListener locLis;
    GoogleApiClient mGoogleApiClient;
    public static double lat,lng;
    public static String hello= "hello";

public static String[] description = {};
        //{"yobjkdqhahcs","hello","hiidhcsjhjdbc"};
public static   Stack<LatLng> locations;
public static String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Log.d(TAG, "onCreate: yoyo");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,description);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.etInput);
        textView.setAdapter(adapter);
        textView.setThreshold(1);

        Log.d(TAG, "onCreate: " + textView.getText().toString());




        //Floating Search View Code
        //
        //
        //
//mSearchView = (FloatingSearchView)findViewById(R.id.floating_search_view);
//
//        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
//            @Override
//            public void onSearchTextChanged(String oldQuery, final String newQuery) {
//
//                //get suggestions based on newQuery
//
//                //pass them on to the search view
//            //    mSearchView.swapSuggestions(new List<SearchSuggestion> {""});
//            }
//        });
//        mSearchView.setOnLeftMenuClickListener(
//                new FloatingSearchView.OnLeftMenuClickListener() {
//                    @Override
//                    public void onMenuOpened() {
//
//                    }
//
//                    @Override
//                    public void onMenuClosed() {
//
//                    }
//                });
//        mSearchView.setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
//            @Override
//            public void onActionMenuItemSelected(MenuItem item) {
//
//
//            }
//            @Override
//            public void onMenuItemSelected(MenuItem item){
//
//                }
      //  });


        //ended ended



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        textView.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                super.beforeTextChanged(s, start, count, after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                Log.d(TAG, "onTextChanged: ");
            }

            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if(s.toString().length() >= 2 ) {
                    input = s.toString();
                    TextChanged(input);
                }
                Log.d(TAG, "afterTextChanged: " + input);
            }
        });


        if(textView.getText()!=null) {
         //   input = textView.getText().toString();
            Log.d(TAG, "onCreate: ");
        }



        Log.d(TAG, "onCreate: input = " + input );

        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
        locMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        locLis = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
              final double lati = location.getLatitude();
               final double lngi = location.getLongitude();
           LatLng latLng = new LatLng(lati,lngi);
              PushToStack(latLng);
                Log.d(TAG, "onLocationChanged: lng = " + location.getLongitude());
                Log.d(TAG, "onLocationChanged: lat = " + location.getLatitude());

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
                Log.d(TAG, "onStatusChanged: ");
            }

            @Override
            public void onProviderEnabled(String s) {
                Log.d(TAG, "onProviderEnabled: ");
            }

            @Override
            public void onProviderDisabled(String s) {
                Log.d(TAG, "onProviderDisabled: ");
            }
        };

        Log.d(TAG, "onCreate: " + locMan.getProvider(LocationManager.GPS_PROVIDER) );

        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 123);
        } else {
            if (locMan.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                locMan.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        10000,
                        10,
                        locLis
                );
            }
            else      locMan.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    10000,
                    10,
                    locLis
            );
        }



    }
    public void TextChanged(String TextInput){

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://maps.googleapis.com/maps/api/place/autocomplete/").
                addConverterFactory(GsonConverterFactory.create()).build();

        PlacesApi placesApi = retrofit.create(PlacesApi.class);
        Callback<main_places> callback = new Callback<main_places>() {
            @Override
            public void onResponse(Call<main_places> call, Response<main_places> response) {
                for(int i=0;i<1;++i) {
                    Log.d(TAG, "onResponse: " + response.body()
                                    .getPredictions()[i].getDescription()
                            // .getStatus()
                    );
                }
                for (int i = 0;i< 1; ++i) {
                    description[i] = response.body().getPredictions()[i].getDescription();
                }
                Log.d(TAG, "onResponse: " + description.length);
//                for (int i = 0; i<1; i++) {
//                    Log.d(TAG, "onResponse: " + description[i]);
//                }
               
            }

            @Override
            public void onFailure(Call<main_places> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        };
        placesApi.call_places( TextInput,getString(R.string.places_api_web_service)).enqueue(callback);

    }




//MENU

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.StreetView){
            startActivity(new Intent(MapsActivity.this,StreetActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.street,menu);
        return super.onCreateOptionsMenu(menu);
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        Log.d(TAG, "onMapReady: ");
        Log.d(TAG, "onMapReady: " );
        // Add a marker in Sydney and move the camera
        Log.d(TAG, "onMapReady: " + lat + " " + lng);
        LatLng currentLocation = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(currentLocation).title("Your are currently at"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
//        mMap.setMaxZoomPreference(15);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 10.0f));
        Log.d(TAG, "onMapReady: " + hello);

    }
    @Override
    public void onMapClick(LatLng latLng) {
        Log.d(TAG, "onMapClick: " + String.valueOf(latLng.latitude) + "  " + String.valueOf(latLng.longitude));
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude,latLng.longitude)));
        //     mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latLng.latitude,latLng.longitude)));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        //    if(true) Toast.makeText(this, marker.getTitle(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        return false;
    }





    @SuppressWarnings("MissingPermission")
    void startLocationTracking () {

        locMan.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                10000,
                10,
                locLis
        );
    }
    public void PushToStack(LatLng latLng){
     //  locations.push(latLng);
        Log.d(TAG, "PushToStack: " );
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (permissions[0].equals(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationTracking();


            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
        Log.d(TAG, "onLocationChanged: lng = " + location.getLongitude());
        Log.d(TAG, "onLocationChanged: lat = " + location.getLatitude());
        Log.d(TAG, "onLocationChanged: ");

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d(TAG, "onStatusChanged: ");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d(TAG, "onProviderEnabled: ");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d(TAG, "onProviderDisabled: ");
    }
}
