set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_antecedente;
-- drop procedure if exists usp_recuperar_antecedente;
drop procedure if exists usp_insertar_antecedente;
drop function if exists fn_generar_id_antecedente;
drop procedure if exists usp_modificar_antecedente;
drop procedure if exists usp_eliminar_antecedente;
delimiter XD
	create procedure usp_listar_antecedente(pbuscar varchar(50))
		begin
			select *
			from tantecedente
			where id_antecedente like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id antecedente
-- crear genero
	create function fn_generar_id_antecedente()
				returns int
		begin
			set @id_antecedente=(select count(*)from tantecedente);
				if(@id_antecedente=0)then
					return 1;
				else
					begin
						set @id_antecedente=(select max(id_antecedente)from tantecedente)+1;
                        return @id_antecedente;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_antecedente(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tantecedente
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_antecedente(palergias text,
												penfermedades text,
												pmedicamentos text,
												pcreado_en datetime)
		begin
			set @id_antecedente=fn_generar_id_antecedente();
			if exists(	select *
						from tantecedente
						where (id_antecedente=@id_antecedente))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into tantecedente values(@id_antecedente,
												palergias ,
												penfermedades ,
												pmedicamentos ,
												pcreado_en );
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tantecedente;
		end XD 
-- modificar
	
    create procedure usp_modificar_antecedente(pid_antecedente int,
												palergias text,
												penfermedades text,
												pmedicamentos text,
												pcreado_en datetime)
		begin
			if not exists(	select *
						from tantecedente
						where (id_antecedente=pid_antecedente))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update tantecedente set	alergias=palergias ,
											enfermedades=penfermedades ,
											medicamentos=pmedicamentos ,
											creado_en=pcreado_en
						where id_antecedente = pid_antecedente;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tantecedente;
		end XD 
-- call usp_modificar_antecedente('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_antecedente(pid_antecedente int)
		begin
			if exists (select * from tantecedente where id_antecedente=pid_antecedente)then
				if not exists(select * from thistoria where id_antecedente=pid_antecedente)then
						delete from tantecedente where id_antecedente=pid_antecedente;
					begin
						set @mensaje='existo lo eliminaste';
						set @id_error=0;
					end;
				else
					begin
						set @mensaje='error se encuentra en la tabla reservacion';
						set @id_error=1;
					end;
				end if;
			else
				begin
					set @mensaje='no existe antecedente';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tantecedente;
		end XD
        call usp_eliminar_antecedente(1);
        call usp_insertar_antecedente('palergias text',
												'penfermedades text',
												'pmedicamentos text',
												now())