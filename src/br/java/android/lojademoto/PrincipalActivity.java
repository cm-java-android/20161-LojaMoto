package br.java.android.lojademoto;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class PrincipalActivity extends ListActivity {

	private List<Moto> motos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		motos = new ArrayList<Moto>();

		Moto moto = null;

		moto = new Moto();
		moto.setModelo("Honda Biz");
		moto.setAutonomia(2015);
		moto.setAutonomia(42.5f);
		moto.setBairro("Botafogo");
		moto.setEndereco("Rua dois");
		moto.setCapacidadeTanque(8.2f);
		moto.setCilindradas(100);
		moto.setQuilometragem(40000);
		moto.setCidade("Rio de Janeiro");
		moto.setUf("RJ");
		motos.add(moto);

		moto = new Moto();
		moto.setModelo("Honda FUN");
		moto.setAutonomia(2009);
		moto.setAutonomia(42.5f);
		moto.setBairro("Botafogo");
		moto.setEndereco("Rua dois");
		moto.setCapacidadeTanque(12.2f);
		moto.setCilindradas(125);
		moto.setQuilometragem(400);
		moto.setCidade("São Gonçalo");
		moto.setUf("RJ");
		motos.add(moto);

		moto = new Moto();
		moto.setModelo("Yamaha Fazer");
		moto.setAutonomia(2013);
		moto.setAutonomia(35.5f);
		moto.setBairro("Copacabana");
		moto.setEndereco("Rua tres");
		moto.setCapacidadeTanque(10.2f);
		moto.setCilindradas(100);
		moto.setQuilometragem(6000);
		moto.setCidade("Rio de Janeiro");
		moto.setUf("RJ");
		motos.add(moto);

		moto = new Moto();
		moto.setModelo("Suzuki Yes");
		moto.setAutonomia(2013);
		moto.setAutonomia(42.5f);
		moto.setBairro("Lapa");
		moto.setEndereco("Rua Humberto");
		moto.setCapacidadeTanque(8.2f);
		moto.setCilindradas(125);
		moto.setQuilometragem(40000);
		moto.setCidade("Rio de Janeiro");
		moto.setUf("RJ");
		motos.add(moto);

		moto = new Moto();
		moto.setModelo("Honda Bros");
		moto.setAutonomia(2014);
		moto.setAutonomia(42.5f);
		moto.setBairro("Botafogo");
		moto.setEndereco("Rua dois");
		moto.setCapacidadeTanque(10.2f);
		moto.setCilindradas(150);
		moto.setQuilometragem(43500);
		moto.setCidade("Rio de Janeiro");
		moto.setUf("RJ");
		motos.add(moto);

		setListAdapter(new ArrayAdapter<Moto>(
				this, // Contexto da lista
				android.R.layout.simple_list_item_1, // Layout do item
				android.R.id.text1, // Texto que será exibido daquele metodo toString de Moto
				motos)); // Lista com as motos
		
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Moto moto = motos.get(position);
				Intent intent = new Intent(PrincipalActivity.this, DetalheMotoActivity.class);
				intent.putExtra("moto", moto);
				
				startActivity(intent);
			}
		});
	}

}
