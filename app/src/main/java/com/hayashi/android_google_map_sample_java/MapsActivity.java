package com.hayashi.android_google_map_sample_java;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Osaka Station and move the camera
        LatLng latLng = new LatLng(34.702485, 135.495951);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Osaka Station");
        mMap.addMarker(markerOptions);

        LatLng latLng2 = new LatLng(34.705045, 135.498401);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(latLng2);
        markerOptions2.title("Umeda Station");
        mMap.addMarker(markerOptions2);

        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(latLng)
                .add(latLng2);
        polylineOptions.color(Color.RED);
        Polyline polyline = mMap.addPolyline(polylineOptions);

        // 直前の色を変更
        polyline.setColor(Color.parseColor("#6495ed"));
        // 直前に丸みを付ける
        polyline.setStartCap(new RoundCap());
        polyline.setEndCap(new RoundCap());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                latLng,
                16);
        mMap.moveCamera(cameraUpdate);
    }
}
