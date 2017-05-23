package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteService;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	private VisiteService visiteService = Constantes.VISITE_SERVICE;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String path = ((HttpServletRequest) request).getRequestURI();
		int before = (int) System.currentTimeMillis();
		chain.doFilter(request, response);
		int after = (int) System.currentTimeMillis();
		VisiteWeb visite = new VisiteWeb(path,after-before);
		visiteService.sauvegarderVisite(visite);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
