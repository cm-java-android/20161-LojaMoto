package br.java.android.lojademoto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DetalheMotoActivity extends Activity {

	private Moto moto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalhe_moto);
		
		moto = (Moto) getIntent().getExtras().getSerializable("moto");
		
		((TextView)findViewById(R.id.modeloTextView)).setText(moto.getModelo());
		
		((TextView)findViewById(R.id.cilidadradasTextView)).setText(moto.getCilindradas() + " cc");
		((TextView)findViewById(R.id.quilometragemTextView)).setText(moto.getQuilometragem() + "km");
		((TextView)findViewById(R.id.anoFabricacaoTextView)).setText("Fabriado em " + moto.getAnoFabricacao());
		((TextView)findViewById(R.id.autonomiaTextView)).setText(moto.getAutonomia() + " Km/l");
		((TextView)findViewById(R.id.capacidadeTanqueTextView)).setText(moto.getCapacidadeTanque() + " litros");
		((TextView)findViewById(R.id.enderecoTextView)).setText(moto.getEndereco());
		((TextView)findViewById(R.id.bairroTextView)).setText(moto.getBairro());
		((TextView)findViewById(R.id.cidadeTextView)).setText(moto.getCidade());
		((TextView)findViewById(R.id.ufTextView)).setText(moto.getUf());

		((TextView)findViewById(R.id.contatoTextView)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView t = (TextView) v;
				Intent i = new Intent(Intent.ACTION_SENDTO);
				i.setData(Uri.fromParts("mailto:", t.getText().toString(), null));
				i.putExtra(Intent.EXTRA_SUBJECT, "Informações sobre " + moto.getModelo());
				i.putExtra(Intent.EXTRA_TEXT, "Gostaria de receber mais informações sobre " + moto.getModelo());
				startActivity(i);
			}
		});
		
		((TextView)findViewById(R.id.telefoneTextView)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView t = (TextView) v;
				Intent i = new Intent(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:" +  t.getText().toString()));
				startActivity(i);
			}
		});
		

		((TextView)findViewById(R.id.maisInfoButton)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView t = (TextView) v;
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://developer.android.com"));
				startActivity(i);
			}
		});
		
	}
}
