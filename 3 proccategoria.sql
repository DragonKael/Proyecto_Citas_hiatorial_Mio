set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_categoria;
-- drop procedure if exists usp_recuperar_categoria;
drop procedure if exists usp_insertar_categoria;
drop function if exists fn_generar_id_categoria;
drop procedure if exists usp_modificar_categoria;
drop procedure if exists usp_eliminar_categoria;
delimiter XD
	create procedure usp_listar_categoria(pbuscar varchar(50))
		begin
			select *
			from tcategoria
			where nombre like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id categoria
-- crear genero
	create function fn_generar_id_categoria()
				returns int
		begin
			set @id_categoria=(select count(*)from tcategoria);
				if(@id_categoria=0)then
					return 1;
				else
					begin
						set @id_categoria=(select max(id_categoria)from tcategoria)+1;
                        return @id_categoria;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_categoria(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tcategoria
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_categoria(pnombre varchar(50),																					
											pcreado_en datetime)
		begin
			set @id_categoria=fn_generar_id_categoria();
			if exists(	select *
						from tcategoria
						where (id_categoria=@id_categoria))then
				begin
					set @mensaje='error ya existe';
					set @id_error=1;
				end;
			else
				if exists(	select *
							from tcategoria
							where (nombre=pnombre))then
					begin
						set @mensaje='error ya existe nombre';
						set @id_error=1;
					end;
				else
					begin
						insert into tcategoria values(@id_categoria,
														pnombre,
														pcreado_en);
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tcategoria;
		end XD 
-- modificar
	
    create procedure usp_modificar_categoria(pid_categoria int,
											pnombre varchar(50),
											pcreado_en datetime)
		begin
			if not exists(	select *
						from tcategoria
						where (id_categoria=pid_categoria))then
				begin
					set @mensaje='error no existe';
					set @id_error=1;
				end;
			else
				if exists(	select *
								from tcategoria
								where (nombre=pnombre))then
						begin
							set @mensaje='error ya existe';
							set @id_error=1;
						end;
					else
					begin
						update tcategoria set	nombre=pnombre,
												creado_en=pcreado_en
							where id_categoria = pid_categoria;
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tcategoria;
		end XD 
-- call usp_modificar_categoria('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_categoria(pid_categoria int)
		begin
			if exists (select * from tcategoria where id_categoria=pid_categoria)then
				if not exists(select * from tespecialidad where id_categoria=pid_categoria)then
						delete from tcategoria where id_categoria=pid_categoria;
					begin
						set @mensaje='existo';
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
					set @mensaje='no existe categoria';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;		
		end XD
        call usp_insertar_categoria('nombre' ,																					
									now())